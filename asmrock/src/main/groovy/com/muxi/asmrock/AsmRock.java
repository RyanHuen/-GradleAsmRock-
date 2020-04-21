package com.muxi.asmrock;

import com.android.build.gradle.AppExtension;
import com.muxi.asmrock.transform.AsmRockCodeTransform;

import org.gradle.api.Plugin;
import org.gradle.api.Project;


/**
 * debug
 * 执行  ./gradlew assembleXXX -Dorg.gradle.debug=true  --no-daemon
 * 新建remote debug configuration  端口5005
 * 启动debug运行
 */
public class AsmRock implements Plugin<Project> {
    @Override
    public void apply(Project project) {

        //AppExtension 就是 Android项目中的build.gradle下android对应的配置类:
        // android {
        //    compileSdkVersion 29
        //    buildToolsVersion "29.0.2"
        //    defaultConfig {
        //        applicationId "com.muxi.gradleasmrock"
        //        minSdkVersion 23
        //        targetSdkVersion 29
        //        versionCode 1
        //        versionName "1.0"
        //    }
        //}
        // AppExtension是Android的gradle插件提供的，这就是为什么我们要在asm_rock的module中引用:
        // implementation 'com.android.tools.build:gradle:3.6.2'
        // implementation 'com.android.tools.build:gradle-api::3.6.2'
        AppExtension appExtension = (AppExtension) project.getProperties().get("android");//获取android属性相关的配置类
        if (appExtension != null) {
            appExtension.registerTransform(new AsmRockCodeTransform(project));//获取到Android项目的配置类，Transform就是注册到AppExtension中的。
        }
    }
}
