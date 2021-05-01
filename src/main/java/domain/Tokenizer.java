package domain;

import java.util.List;

public interface Tokenizer<T> {
  List<T> tokenize(String tokenTarget);
}
