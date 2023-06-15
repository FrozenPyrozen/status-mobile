(ns quo2.components.network-connections.view
  (:require
    [react-native.core :as rn]
    [quo2.components.network-connections.style :as style]
    [taoensso.timbre :as log]
  ))

(defn network-connections-item-render
  "This component based on the following properties:
  - :item - item which got color, amount, currency, icon, network properties 
  "
  [{:keys {[amount, network, currency, icon , connectedTo?, connectedFrom? ,id, color]}}]
  [rn/view
   {:style               [style/item-container {:border-color color}]
    :accessibility-label :network-connections-item-container}
   [rn/view
    {:style [style/item-row]}
    [rn/text
     {:style [style/amount]} amount]
    [rn/text
     {:style [style/currency]} currency]]]
  [rn/view
   {:style [style/item-row]}
   [rn/view
    {:style [style/icon-container]}
    [rn/view
     {:style [style/icon]}]  [rn/text
    {:style [style/title]} icon]]
   [rn/text
    {:style [style/title]} network]])

(defn network-connections
  "This component based on the following properties:
  - :from - vector of from connections
  - :to - vector of to connections
  "
  [{:keys [from to]}]
  [rn/view
   {:style               style/container
    :accessibility-label :network-connections-container}
   [rn/view
    {:style               style/column
     :accessibility-label :network-connections-column-left}
    [rn/text "From"]
    [rn/flat-list
     {:flex                         1
      :keyboard-should-persist-taps :always
      :data                         from
      :listKey "From Column"
      :render-fn                    network-connections-item-render
      :key-fn                       :id}]]
   [rn/view
    {:style               style/column
     :accessibility-label :network-connections-column-right}
    [rn/text "To"]
    
    [rn/flat-list
     {:flex                         1
      :keyboard-should-persist-taps :always
      :data                         to
      :listKey "To Column"
      :render-fn                    network-connections-item-render
      :key-fn                       :id}]]])