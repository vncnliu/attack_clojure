(ns me.vncnliu.attack.clojure.http.server
  (:use ring.util.response
        ring.adapter.jetty))

(defn handler [request]
  (-> (response "Hello World")
      (content-type "text/plain")))

(run-jetty handler {:port 3000})