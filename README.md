# debug-groovy-bug

Steps to reproduce:
1. Set a breakpoint on the first line of `foo.bar.JMain#main`
2. Debug `foo.bar.JMain` (⌃⇧D)
3. Step into `foo.bar.JMain#tryStuff`
4. Step into `constructor.newInstance()` and ` method.invoke(o)` inside `#tryStuff`

Last step works for both both `foo.bar.JC` and `foo.bar.SGC`, while fails for `foo.bar.GC`.
The same behaviour persists when running `foo.bar.GMain` and stepping into methods inside its `#main`.
