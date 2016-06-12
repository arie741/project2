(ns ariereframe2.views
    (:require [re-frame.core :as re-frame]
              [reagent.core :as reagent]))


;; Helper Functions
(defn find-q-by-id [id data]
  (first (filter #(= id (:id %)) (:questions data))))

(defn get-q-ids []
  (let [q (.getElementsByTagName js/document "question")]
    (for [i (range (.-length q))]
      (.-id (aget q i)))))

;;Functions

(defn asnf [ca i]
  (if (= ca i)
    (js/alert "correct!")
    (js/alert "wrong!")))

(defn swap-quest []
  (let [data (re-frame/subscribe [:data])
        q (.getElementsByTagName js/document "question")]
    (doseq [i (get-q-ids)]
      ^{:keys i}
      (do 
        (reagent/render 
          [#(quest 
              (:question (find-q-by-id i @data))
              (:answers (find-q-by-id i @data))
              (:key (find-q-by-id i @data)))]
          (.getElementById js/document i))
        (.setAttribute (.getElementById js/document i) "id" (str i "s"))))))

;;Snippets

(defn quest [q ans ca]
  [:ul q
   (for [[i j] (map vector (keys ans) (vals ans))]
     ^{:key i}
          [:li 
           [:button {:on-click #(asnf ca i)} (str i ". " j)]])])

;;Templates

(defn main-panel []
  (let [data (re-frame/subscribe [:data])]
   [:div {:id "content"}
   [:h1 "Module"]]))