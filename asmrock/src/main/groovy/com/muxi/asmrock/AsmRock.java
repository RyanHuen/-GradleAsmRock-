package com.muxi.asmrock;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class AsmRock implements Plugin<Project> {
    @Override
    public void apply(Project project) {

        System.out.println("Hello world!AsmRock!");
    }
}
