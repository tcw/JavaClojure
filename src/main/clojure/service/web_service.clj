(ns service.web-service
  (:use compojure.core
        ring.adapter.jetty
        ring.middleware.json)
  (:require [compojure.route :as route]
            [ring.util.response :as resp]
            [compojure.handler :as handler]))

(defroutes main-routes
           (GET "/" [] (resp/response {"hello" "World"}))
           (route/not-found "Page not found"))

(def app
  (-> main-routes
      handler/api
      wrap-json-response))

(defn start-web-app [& args]
  (run-jetty app {:port 3000}))
