package com.example.kson.a8creflection.butterknife;

import android.app.Activity;
import android.view.View;

import com.example.kson.a8creflection.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ButterKnife {
    public static void bind(Activity activity) {
        bindContentView(activity);
        try {
            bindView(activity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化根布局
     *
     * @param activity
     */
    private static void bindContentView(Activity activity) {

        //第一步
        Class<?> c = activity.getClass();

        //获取类的注解
        ContentView contentView = c.getAnnotation(ContentView.class);
        if (contentView != null) {

//            activity.setContentView(layoutId);
            try {
                int layoutId = contentView.value();
                Method method = c.getMethod("setContentView", int.class);
                method.invoke(activity, layoutId);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 初始化控件
     *
     * @param activity
     */
    private static void bindView(Activity activity) throws IllegalAccessException {

        Class<?>  c = activity.getClass();

        Field[] fields = c.getDeclaredFields();
        if (fields!=null&&fields.length>0){


            for (Field field : fields) {
                BindView bindView = field.getAnnotation(BindView.class);
                if (bindView!=null){
                    int viewId = bindView.value();
                    View view = activity.findViewById(viewId);
                    field.setAccessible(true);
                    field.set(activity,view);
                }


            }
        }

    }


}
