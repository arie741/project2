(ns ariereframe2.handlers
    (:require [re-frame.core :as re-frame]
              [ariereframe2.db :as db]))

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))
