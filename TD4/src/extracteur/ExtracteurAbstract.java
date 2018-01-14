package extracteur;

public abstract class ExtracteurAbstract implements Extracteur {
	
    @Override
    public InfosMot getNext() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Boolean regexJumpLine(char c) {

        return c == '\n';
    }

}
