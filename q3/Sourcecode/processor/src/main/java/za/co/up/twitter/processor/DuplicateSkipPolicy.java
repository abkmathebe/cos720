package za.co.up.twitter.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.transform.IncorrectTokenCountException;
import org.springframework.dao.DuplicateKeyException;

import java.io.FileWriter;
import java.io.IOException;

public class DuplicateSkipPolicy implements SkipPolicy {

    private static final Logger logger = LoggerFactory.getLogger(DuplicateSkipPolicy.class);

    @Override
    public boolean shouldSkip(Throwable exception, int skipCount) {
        return true;
    }
}
