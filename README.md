## MineSweeper

### Compile

    gradle assemble

### build and jar

    gradle build

### Generate Javadoc

    gradle javadoc

Output found in `build/docs/javadoc`

### Run gradle faster

Always use `gradle --daemon` to cache the binary and its loaded plugins:

    alias gradle='gradle --daemon'
