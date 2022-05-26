package com.training;

import com.training.resources.AuthorResource;
import com.training.resources.BookResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        try {
            new App().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new BookResource());
        environment.jersey().register(new AuthorResource());
    }
}

//just add the service layer then run the code. ;)
//then do jdbc mysql
//then do hibernate