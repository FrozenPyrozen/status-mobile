(ns quo2.components.network-connections.style
  (:require [quo2.foundations.colors :as colors]
            [utils.re-frame :as rf]))

;; (def window-width (rf/sub [:dimensions/window-width]))

(def container
  {:flex-direction     :row
   :align-items        :center
   :justify-content    :space-between
;;   :background-color   :red
   :padding-horizontal 10
   :margin-bottom      20})

(def column
  {:flex        1
   :align-items :flex-start})

(def item-container
  {:width              300
   :height             44
   :flex               1
   :flex-direction     :column
   :align-items        :flex-start
   :border-radius      12
   :border-width       1
;;   :border-color       :green
   :padding-horizontal 8
   :padding-vertical   5
;;  :background-color   :grey
  })

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
  {:width  12
   :height 12})

(def title
  {})