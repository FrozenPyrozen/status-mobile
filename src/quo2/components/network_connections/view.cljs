(ns quo2.components.network-connections.view
  (:require
    [react-native.core :as rn]
    [quo2.components.network-connections.style :as style]
    [status-im.ui.components.fast-image :as fast-image]
    [taoensso.timbre :as log]
    [status-im.ui.components.react :as react]
    [utils.re-frame :as rf]
    [status-im2.contexts.onboarding.common.background.view :as background]))

(defn- network-connections-item-render
  "This component based on the following properties:
  - :item - item which got color, amount, currency, icon, type properties 
  "
  [{:keys [amount type currency icon connectedTo? connectedFrom? id color]} window-width]
  [rn/view
   {:style (style/item-container color window-width) :key id}
   [rn/view
    {:style style/item-row}
    [rn/text
     {:style style/amount} amount]
    [rn/text
     {:style style/currency} currency]]
   [rn/view
    {:style style/item-row}
    [rn/view
     {:style style/icon-container}
     [fast-image/fast-image
      {:style       style/icon
       :resize-mode :contain
       :source      icon}]
    ]
    [rn/text
     {:style style/title} type]]
  ])

;; TODO: remove it later qwerty1234567890
(defn network-connections
  "This component based on the following properties:
  - :from - vector of from connections
  - :to - vector of to connections
  "
  [{:keys [from to]}]

  (let [window-width (rf/sub [:dimensions/window-width])]
    [rn/view
     {:style               style/container
      :accessibility-label :network-connections-container}
     [rn/view
      {:style               style/column
       :accessibility-label :network-connections-column-left}
      [rn/text {:style style/column-title} "From"]
      [react/scroll-view {:style style/scroll-container}
       (for [network-connection-from-item from]
         ^{:key (get network-connection-from-item :id)}
         [network-connections-item-render network-connection-from-item window-width])]]
     [rn/view
      {:style               style/column
       :accessibility-label :network-connections-column-right}
      [rn/text {:style style/column-title} "To"]
      [react/scroll-view {:style style/scroll-container}
       (for [network-connection-to-item to]
         ^{:key (get network-connection-to-item :id)}
         [network-connections-item-render network-connection-to-item window-width])]]]))