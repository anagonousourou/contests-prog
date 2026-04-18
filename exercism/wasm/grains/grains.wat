(module
  (type (;0;) (func (param i32) (result i64)))
  (type (;1;) (func (result i64)))
  (func (;0;) (type 0) (param i32) (result i64)
    (local i64 i64 i32)
    block  ;; label = @1
      local.get 0
      i32.const 1
      i32.sub
      local.tee 3
      i32.const 63
      i32.gt_u
      br_if 0 (;@1;)
      i64.const 1
      local.set 1
      block  ;; label = @2
        block  ;; label = @3
          local.get 0
          i32.const 1
          i32.sub
          br_table 2 (;@1;) 1 (;@2;) 0 (;@3;)
        end
        i64.const 2
        local.set 1
        i64.const 1
        local.set 2
        loop  ;; label = @3
          local.get 1
          i64.const 1
          local.get 3
          i32.const 1
          i32.and
          select
          local.get 2
          i64.mul
          local.set 2
          local.get 3
          i32.const 3
          i32.gt_u
          local.get 1
          local.get 1
          i64.mul
          local.set 1
          local.get 3
          i32.const 1
          i32.shr_u
          local.set 3
          br_if 0 (;@3;)
        end
        local.get 1
        local.get 2
        i64.mul
        return
      end
      i64.const 2
      local.set 1
    end
    local.get 1)
  (func (;1;) (type 1) (result i64)
    i64.const -1)
  (memory (;0;) 17)
  (export "memory" (memory 0))
  (export "square" (func 0))
  (export "total" (func 1)))
