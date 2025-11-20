(module
  (type (;0;) (func (param f64 f64) (result i32)))
  (func (;0;) (type 0) (param f64 f64) (result i32)
    block (result i32)  ;; label = @1
      i32.const 0
      local.get 0
      local.get 0
      f64.mul
      local.get 1
      local.get 1
      f64.mul
      f64.add
      f64.sqrt
      local.tee 0
      f64.const 0x1.4p+3 (;=10;)
      f64.gt
      br_if 0 (;@1;)
      drop
      i32.const 1
      local.get 0
      f64.const 0x1.4p+2 (;=5;)
      f64.gt
      br_if 0 (;@1;)
      drop
      i32.const 5
      i32.const 10
      local.get 0
      f64.const 0x1p+0 (;=1;)
      f64.gt
      select
    end)
  (memory (;0;) 17)
  (export "memory" (memory 0))
  (export "score" (func 0)))
