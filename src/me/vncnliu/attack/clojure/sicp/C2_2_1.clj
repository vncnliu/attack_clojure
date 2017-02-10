(ns me.vncnliu.attack.clojure.sicp.c2-2-1)

;e2.17
(defn last-pair [iterms]
  (if (nil? (seq iterms))
    (throw (nullpointerexception. "iterms is null"))
    (if (nil? (next iterms))
      iterms
      (last-pair (rest iterms))
      )
    ))

;e2.18
(defn scale-list [items factor]
        (if (empty? items)
          nil
          (cons (* (first items) factor)
                (scale-list (next items)
                            factor))))

