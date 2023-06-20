(ns quo2.components.network-connections.style
  (:require [quo2.foundations.colors :as colors]
  ))


(def container
  {:flex               1
   :flex-direction     :row
   :align-items        :center
   :justify-content    :space-between
   :padding-horizontal 10
   :margin-bottom      20})

(def column
  {:flex        1
   :align-items :flex-start})


(defn item-container
  [border-color window-width]
  {:width           (/ window-width 3)
   :height          44
   :flex            1
   :flex-direction  :column
   :align-items     :flex-start
   :justify-content :center
   :margin-bottom   12
   :border-color    border-color
   :border-width    1
   :border-radius   12})

(def item-row
  {:flex             1
   :flex-direction  :row
   :align-items      :center})

(def amount
  {:margin-right 4})

(def currency
  {:margin-right 4})

(def icon-container
  {:width            20
   :height           20
   :margin-right     4
   :align-items     :flex-start
   :justify-content  :center
  })

(def icon
  {:width  12
   :height 12})

(def title
  {})