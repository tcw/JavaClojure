package somejava;

import clojure.api.API;
import clojure.lang.IFn;

public class CallClojure {

    public static void main(String[] args) throws InterruptedException {
        IFn require = API.var("clojure.core", "require");
        require.invoke(API.read("service.web-service"));
        IFn service = API.var("service.web-service", "start-web-app");
        service.invoke();
    }
}
