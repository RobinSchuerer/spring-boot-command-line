package de.robinschuerer.base.argument;

import java.io.File;

import javax.annotation.Nonnull;

public class IndexerConfiguration {

    private boolean inValid;
    private String errorMessage;
    private File dataFile;

    private IndexerConfiguration(@Nonnull final Builder builder) {
        this.inValid = builder.inValid;
        this.errorMessage = builder.errorMessage;
        this.dataFile = builder.dataFile;
    }

    public boolean isInValid() {
        return inValid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public File getDataFile() {
        return dataFile;
    }

    @Nonnull
    public static IndexerConfiguration invalid(final String message) {
        return newBuilder()
            .withInValid()
            .withErrorMessage(message)
            .build();
    }

    @Nonnull
    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private boolean inValid;
        private String errorMessage;
        private File dataFile;

        private Builder() {
        }

        @Nonnull
        public Builder withInValid() {
            this.inValid = true;
            return this;
        }

        @Nonnull
        public Builder withErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        @Nonnull
        public Builder withDataFile(File dataFile) {
            this.dataFile = dataFile;
            return this;
        }

        @Nonnull
        public IndexerConfiguration build() {
            return new IndexerConfiguration(this);
        }
    }
}
