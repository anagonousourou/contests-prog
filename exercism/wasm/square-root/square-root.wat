(module
  (type (;0;) (func (param i32) (result i32)))
  (func (;0;) (type 0) (param i32) (result i32)
    (local f32)
    local.get 0
    f32.convert_i32_s
    f32.sqrt
    local.tee 1
    f32.const -0x1p+31 (;=-2.14748e+09;)
    f32.ge
    local.set 0
    i32.const 2147483647
    block (result i32)  ;; label = @1
      local.get 1
      f32.abs
      f32.const 0x1p+31 (;=2.14748e+09;)
      f32.lt
      if  ;; label = @2
        local.get 1
        i32.trunc_f32_s
        br 1 (;@1;)
      end
      i32.const -2147483648
    end
    i32.const -2147483648
    local.get 0
    select
    local.get 1
    f32.const 0x1.fffffep+30 (;=2.14748e+09;)
    f32.gt
    select
    i32.const 0
    local.get 1
    local.get 1
    f32.eq
    select)
  (memory (;0;) 17)
  (export "memory" (memory 0))
  (export "squareRoot" (func 0)))
