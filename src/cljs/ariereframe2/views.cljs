(ns ariereframe2.views
    (:require [re-frame.core :as re-frame]))

(defn find-q-by-id [id data]
  (first (filter #(= id (:id %)) (:questions data))))

(defn quest [q ans]
  [:ul q
   (for [[i j] (map vector (keys ans) (vals ans))]
     ^{:key i}
          [:li (str i ". " j)])])

(defn get-q-ids []
  (let [q (.getElementsByTagName js/document "question")]
    (for [i (range (.-length q))]
      (.-id (aget q i)))))

(defn swap-quest []
  (let [data (re-frame/subscribe [:data])
        q (.getElementsByTagName js/document "question")]
    (doseq [i (get-q-ids)]
      ^{:keys i}
      (set! (.-innerHTML (.getElementById js/document i)) 
            (quest 
              (:question (find-q-by-id i @data))
              (:answers (find-q-by-id i @data)))))))

(defn main-panel []
  (let [data (re-frame/subscribe [:data])]
   [:div {:id "content"}
   [:h1 "Module"]
   [:p (str "asd" (get-q-ids))]]))