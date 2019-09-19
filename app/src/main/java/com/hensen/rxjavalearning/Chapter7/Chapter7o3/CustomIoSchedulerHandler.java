package com.hensen.rxjavalearning.Chapter7.Chapter7o3;

import io.reactivex.Scheduler;
import io.reactivex.functions.Function;

/**
 * Created by handsomexu on 2018/10/6.
 */

public class CustomIoSchedulerHandler implements Function<Scheduler, Scheduler> {
    @Override
    public Scheduler apply(Scheduler scheduler) throws Exception {
        return null;
    }
}
