(module
  (type (;0;) (func (param i32) (result i32)))
  (func (;0;) (type 0) (param i32) (result i32)
    local.get 0
    i32.const 400
    i32.rem_u
    i32.eqz
    if  ;; label = @1
      i32.const 1
      return
    end
    local.get 0
    i32.const 100
    i32.rem_u
    i32.eqz
    if  ;; label = @1
      i32.const 0
      return
    end
    local.get 0
    i32.const 3
    i32.and
    i32.eqz)
  (memory (;0;) 17)
  (export "memory" (memory 0))
  (export "isLeap" (func 0)))
