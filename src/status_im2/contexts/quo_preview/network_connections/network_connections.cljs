(ns status-im2.contexts.quo-preview.network-connections.network-connections
  (:require [quo2.components.markdown.text :as text]
            [quo2.components.network-connections.view :as quo2]
            [quo2.foundations.colors :as colors]
            [react-native.core :as rn]
            [reagent.core :as reagent]
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
  (let [state
        (reagent/atom
         {:from [{:amount      "50"
                  :type        "Mainnet"
                  :currency    "ETH"
                  :icon        (js/require "../resources/images/icons/ethereum.png")
                  :connectedTo ""
                  :color       "#758EEB"
                  :id          0}
                 {:amount      "50"
                  :type        "Optimism"
                  :currency    "ETH"
                  :icon        (js/require "../resources/images/icons/optimism.png")
                  :connectedTo ""
                  :color       "#E76E6E"
                  :id          1}
                 {:amount      "50"
                  :type        "Arbitrum"
                  :currency    "ETH"
                  :icon        (js/require "../resources/images/icons/arbitrum.png")
                  :connectedTo ""
                  :color       "#6BD5F0"
                  :id          2}]
          :to
          [{:amount        "50"
            :type          "Mainnet"
            :currency      "ETH"
            :icon          (js/require "../resources/images/icons/ethereum.png")
            :connectedFrom ""
            :color         "#758EEB"
            :id            3}
           {:amount        "50"
            :type          "Optimism"
            :currency      "ETH"
            :icon          (js/require "../resources/images/icons/optimism.png")
            :connectedFrom ""
            :color         "#6BD5F0"
            :id            4}]})]
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
     :listKey                      "preview-network-connections"
     :header                       [cool-preview]
     :key-fn                       str}]])
