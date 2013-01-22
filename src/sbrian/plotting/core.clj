(ns sbrian.plotting.core
  (import com.sbrian.simplegraphics.View))

(def ^{:private true} view (new View))

(defn clear-view []
  (. view clear))

(defn show-v [v]
  (if
    (or (nil? (v 0)) (nil? (v 1)))
    v
    (do
      (. view setVisible true)
      (. view (setPoint (v 0) (v 1)))
      v)))

(defn hide-v [v]
  (. view (unsetPoint (v 0) (v 1)))
  v)

(defn show-m [a]
    (. view setVisible true)
    (doall (map show-v a))
    a)

(defn hide-m [a]
  (doall (map hide-v a))
  a)





