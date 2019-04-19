# debug-groovy-bug

Steps to reproduce:
1. Set a breakpoint on the first line of `foo.bar.JMain#main`
2. Debug `foo.bar.JMain` (⌃⇧D)
3. Step into `foo.bar.JMain#tryStuff`
4. Step into `constructor.newInstance()` and ` method.invoke(o)` inside `#tryStuff`

Last step works for both both `foo.bar.JC` and `foo.bar.SGC`, while fails for `foo.bar.GC`.
The same behaviour persists when running `foo.bar.GMain` and stepping into methods inside its `#main`.

This issue is reproducible with plain raw jdb:
```
$ ./gradlew clean classes
$ jdb -classpath build/classes/groovy/main:<path to groovy-2.5.6.jar>
```
Inside jdb prompt:
```
> sourcepath src/main/groovy
> exclude java.*,sun.*,com.sun.*,groovy.*,org.codehaus.groovy.*,org.apache.groovy.*
> stop in foo.bar.GMain.main
> run foo.bar.GMain
```
Then `step` until the end and observe the behaviour.
