(ns quo2.components.network-connections.style
  (:require [quo2.foundations.colors :as colors]
  ))


(def container
  {:flex            1
   :flex-direction  :row
   :justify-content :space-between
  })

(def column-title
  {})

(def column
  {:flex            1
   :flex-direction  :column
   :justify-content :space-between
  })

(def scroll-container
  {:flex-shrink 0
   :flex-grow   1})


(defn item-container
  [border-color window-width]
  {:flex               1
   :height             44
   :flex-direction     :column
   :align-items        :flex-start
   :justify-content    :center
   :margin-bottom      12
   :border-color       border-color
   :border-width       1
   :border-radius      12
   :padding-horizontal 5
   :padding-vertical   8
   :overflow           :hidden})

(def item-row
  {:flex-direction :row
   :align-items    :center
  })

(def amount
  {})

(def currency
  {:margin-left 5})

(def icon-container
  {:align-items     :flex-start
   :justify-content :center
  })

(def icon
  {:width  12
   :height 12})

(def title
  {:margin-left 5})