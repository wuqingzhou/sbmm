package wqz.model.sbmm.busproject.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppUtil {
    public static ExecutorService executorService = Executors.newFixedThreadPool(300);
}
