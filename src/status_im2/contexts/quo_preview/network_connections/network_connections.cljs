(ns status-im2.contexts.quo-preview.network-connections.network-connections
  (:require [quo2.components.markdown.text :as text]
            [quo2.components.network-connections.view :as quo2]
            [quo2.foundations.colors :as colors]
            [react-native.core :as rn]
            [reagent.core :as reagent]
            [taoensso.timbre :as log]
            [status-im2.contexts.quo-preview.preview :as preview]))

(def descriptor
  [{:label "Disabled"
    :key   :disabled?
    :type  :boolean}
   {:label "Blur"
    :key   :blur?
    :type  :boolean}
   {:label   "Customization color"
    :key     :customization-color
    :type    :select
    :options (map (fn [[color _]]
                    {:key color :value (name color)})
                  colors/customization)}])

(defn network-connection-preview
  [text component {:keys [from to]}]
  (log/debug "from" from "to" to)

  [rn/view
   {:style {:margin      6
            :align-items :center}}
   [text/text {:size :paragraph-1} text]
   [component
    {:to   to
     :from from
    }]])

(defn cool-preview
  []
  (let [state (reagent/atom
               {:from [{:amount 50 :label "Mainnet" :currency :ETH :icon "Test" :connectedTo "" :id 0}
                       {:amount 50 :label "Optimism" :currency :ETH :icon "Test" :connectedTo "" :id 1}
                       {:amount 50 :label "Arbitrum" :currency :ETH :icon "Test" :connectedTo "" :id 2}]
                :to
                [{:amount 100 :label "Optimism" :currency :ETH :icon "Test" :connectedFrom "" :id 3}
                 {:amount 50 :label "Optimism" :currency :ETH :icon "Test" :connectedFrom "" :id 4}]})]
    (fn []
      [rn/view
       [preview/customizer state descriptor]
       [rn/view {:style {:margin-vertical 24}}
        [network-connection-preview "Network connections" quo2/network-connections @state]
       ]])))


(defn preview-network-connections
  []
  [rn/view
   {:style {:background-color (colors/theme-colors colors/white colors/neutral-95)
            :flex             1}}
   [rn/flat-list
    {:style                        {:flex 1}
     :keyboard-should-persist-taps :always
     :header                       [cool-preview]
     :key-fn                       str}]])
