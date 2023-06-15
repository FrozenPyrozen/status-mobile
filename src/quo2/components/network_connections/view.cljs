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
  [item]
  [rn/view
   {:style               [style/item-container {:border-color item.color}]
    :accessibility-label :network-connections-item-container}
   [rn/view
    {:style [style/item-row]}
    [rn/text
     {:style [style/amount]} item.amount]
    [rn/text
     {:style [style/currency]} item.currency]]]
  [rn/view
   {:style [style/item-row]}
   [rn/view
    {:style [style/icon-container]}
    [rn/view
     {:style [style/icon]}]]
   [rn/text
    {:style [style/title]} item.network]])

(defn network-connections
  "This component based on the following properties:
  - :from - vector of from connections
  - :to - vector of to connections
  "
  [{:keys [from to]}]
  (log/debug "from" from "to" to)
  [rn/view
   {:style               style/container
    :accessibility-label :network-connections-container}
   [rn/view
    {:style               style/column
     :accessibility-label :network-connections-column-left}
    [rn/flat-list
     {:flex                         1
      :keyboard-should-persist-taps :always
      :data                         from
      :render-fn                    network-connections-item-render
      :key-fn                       str}]]
   [rn/view
    {:style               style/column
     :accessibility-label :network-connections-column-right}
    [rn/flat-list
     {:flex                         1
      :keyboard-should-persist-taps :always
      :data                         to
      :render-fn                    network-connections-item-render
      :key-fn                       str}]]])