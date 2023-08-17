package csci318.demo.controller.dto;

import csci318.demo.model.Library;

public class LibraryDto {

    private final String libraryName;
    private final String postcode;

    public LibraryDto(Library library) {
        this.libraryName = library.getName();
        this.postcode = Long.toString(library.getId());
    }

    public String getLibraryName() {
        return libraryName;
    }

    public String getPostcode() {
        return postcode;
    }
}
