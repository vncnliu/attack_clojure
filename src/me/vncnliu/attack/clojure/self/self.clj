(ns me.vncnliu.attack.clojure.self.self)

(defn factorial [n]
  (if (= 1 n)
    (/ 1 100)
    (* (/ n 100) (factorial (dec n)))))

(defn temp-array [n]
    (if (= 1 n)
    [1]
    (conj (temp-array (dec n)) n)))

(defn length [coll]
  (if (empty? coll)
    0
    (+ 1 (length (rest coll)))))

(defn get-array [n]
  (int-array (temp-array n)))

(defn swap [array index1 index2]
  (let [temp (aget array index1)]
  (aset array index1 (aget array index2))
  (aset array index2 temp)))

(defn rand-part-array [array part-array partln swapln]
  (let [temp (rand-int swapln)]
    (conj part-array (aget array temp))
    (swap array temp swapln)
    (if (= partln (length part-array))
      part-array
      (rand-part-array array part-array partln (dec swapln)))))

(defn rand_part [array partln part-array]
  (if (= (count part-array) (+ partln (count part-array)))
    part-array
    (if (< (rand) (/ partln (count array)))
      (recur (rest array) (dec partln) (conj part-array (first array)))
      (recur (rest array) partln part-array))))

(use 'clojure.java.io)

(defn get_str [n]
  (if (< n 1)
    ()
    (conj (get_str (dec n)) (rand_part (list 1 2 3 4 5 6) 3 ()))))
(defn write-in-file [n] (with-open [wrtr (writer "a.txt":append true)]
                          (.write wrtr (pr-str (get_str n)))))

(defn stack-consuming-fibo [n]
  (cond
    (= n 0) 0 ; <label id="code.stack-consuming-fibo.0"/>
    (= n 1) 1 ; <label id="code.stack-consuming-fibo.1"/>
    :else (+ (stack-consuming-fibo (- n 1))    ; <label id="code.stack-consuming-fibo.n"/>
             (stack-consuming-fibo (- n 2)))))     ; <label id="code.stack-consuming-fibo.n2"/>
; END: stack-consuming-fibo

; START: tail-fibo
(defn tail-fibo [current next n]
            (if (zero? n)
              current       ; <label id="code.tail-fibo.terminate"/>
              (recur next (+ current next) (dec n))))

(use 'clojure.tools.trace)

(dotrace [tail-fibo] (tail-fibo 0 1 3))