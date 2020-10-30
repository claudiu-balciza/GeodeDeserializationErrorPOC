package org.deserializationError;

import org.deserializationError.domain.Class1;
import org.deserializationError.repositories.GeodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
  @Autowired
  private GeodeRepository repository;

  @Override
  public void run(String... args) throws Exception {
    repository.deleteAll();

    repository.save(new Class1(1, "aaaa"));
    repository.save(new Class1(2, "bbbb"));
    repository.save(new Class1(3, "cccc"));

//    repository.findAll().forEach((item) -> System.out.println(item.toString()));
  }
}
