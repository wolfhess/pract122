package pract12;

public class IDocument implements ICreateDocument {
    public IDocument CreateNew() {
        return new IDocument();
    }

    public IDocument CreateOpen() {
        return new IDocument();
    }
}
