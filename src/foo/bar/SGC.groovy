package foo.bar

import groovy.transform.CompileStatic

@CompileStatic
class SGC {

    SGC() {
        int i = 42
    }

    int getStuff() {
        return 70
    }
}
