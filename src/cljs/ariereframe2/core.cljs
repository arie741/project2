(ns ariereframe2.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [ariereframe2.handlers]
              [ariereframe2.subs]
              [ariereframe2.views :as views]
              [ariereframe2.config :as config]))

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn mount-quest []
  (let [q (.getElementsByTagName js/document "question")]
    (dotimes [i (.-length q)]
      ^{:keys i}
      (reagent/render [views/main-panel]
                      (aget (.getElementsByTagName js/document "question") i)))))

(defn ^:export init [] 
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root)
  (views/swap-quest))
