(module
  (type (;0;) (func (param i32) (result i32)))
  (func (;0;) (type 0) (param i32) (result i32)
    (local i32 i64)
    local.get 0
    i32.const 0
    i32.le_s
    if  ;; label = @1
      i32.const -1
      return
    end
    local.get 0
    i32.const 1
    i32.ne
    if  ;; label = @1
      local.get 0
      i64.extend_i32_u
      local.set 2
      loop  ;; label = @2
        local.get 1
        i32.const 1
        i32.add
        local.set 1
        local.get 2
        i64.const 1
        i64.shr_u
        local.get 2
        i64.const 3
        i64.mul
        i64.const 1
        i64.add
        local.get 2
        i64.const 1
        i64.and
        i64.eqz
        select
        local.tee 2
        i64.const 1
        i64.ne
        br_if 0 (;@2;)
      end
    end
    local.get 1)
  (memory (;0;) 17)
  (export "memory" (memory 0))
  (export "steps" (func 0)))
