(ns advent-of-code-2021.core
  (:require [clojure.java.io :as io])
  (:require [clojure.set])
  (:require [clojure.string])
  (:gen-class))

; file =  {:file-type :file|:directory, :size 4589, :entries [file...]}

(defn run-simulation [input-str]

  )

(defn go-in-directory [file-system, dest-directory]
  (update-in file-system [:context :current-directory] (fn[current-dir] (str current-dir "/" dest-directory)))
  )

(defn go-back [file-system-and-context]
  (update-in file-system-and-context [:context :current-directory] (fn[current-dir] (-> current-dir
                                                                                         (clojure.string/split #"/")
                                                                                         (drop-last)
                                                                                         ((fn[path-segments] (clojure.string/join "/" path-segments))))
                                                                                     ))
  )

(defn go-to-root [file-system]
  (update-in file-system [:context :current-directory] (fn[_] "/"))
  )

(defn command? [input]
  (.startsWith input "$")
  )

(defn execute-command [file-system-and-context, input]
  (cond
    (.contains input "cd ..") (go-back file-system-and-context)
    (.contains input "cd /")  (go-to-root file-system-and-context)
    (.contains input "$ ls")  (update-in file-system-and-context [:context :listing-context] (fn [_] true))
    :else (go-in-directory file-system-and-context (last (re-seq #"[\w]+" input)))
    )
  )

(defn read-file-entry [file-system-and-context, input-str]
  (let [
        words (re-seq #"[\w.]+" input-str)
        file-type (if (= "dir" (first words)) :directory :file)
        current-directory (get-in file-system-and-context [:context :current-directory])
        file-name (str current-directory "/" (second words))
        ]
    (case file-type
      :directory
      :file (update-in file-system-and-context [:file-system file-name] ))
    )

  )



(defn rebuild-file-system [file-system-and-context , command-or-entry]
  (cond
    (command? command-or-entry) (execute-command file-system-and-context command-or-entry)
    )
  )



(defn -main
  "I don't do a lot ... yet."
  [& args]
  (->> "inputs-2022/2022-day6-input"
       (io/resource)
       (slurp)
       (run-simulation)
       (println)
       )
  )
