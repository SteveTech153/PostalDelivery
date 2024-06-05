package System.PostOffice;

import System.PostalManager.PostalManager;

public interface PostOfficeManagerActions {
    void assignManager(PostalManager manager);
    PostalManager getManager();
}
