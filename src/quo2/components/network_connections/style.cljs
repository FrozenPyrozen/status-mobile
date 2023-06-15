(ns quo2.components.network-connections.style
  (:require [quo2.foundations.colors :as colors]))

(def item-width :dimensions/window-width)

(def container
  {:flex-direction     :row
   :align-items        :center
   :justify-content    :space-between
   :padding-horizontal 10
   :margin-bottom      20})

(def column
  {:flex        1
   :align-items :flex-start})

(def item-container
  {:width              item-width
   :height             44
   :flex               1
   :flex-direction     :column
   :align-items        :flex-start
   :border-radius      12
   :border-width       1
   :padding-horizontal 8
   :padding-vertical   5})

(def item-row
  {:flex-direction :row
   :align-items    :center})

(def amount
  {:margin-right 4})

(def currency
  {:margin-right 4})

(def icon-container
  {:width           20
   :height          20
   :margin-right    4
   :align-items     :flex-start
   :justify-content :center

  })

(def icon
  {:width            12
   :height           12
   :background-color :black})

(def title
  {})