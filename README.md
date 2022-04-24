# Github Repo Reader Summer Experience Allegro 2022

* * *

### Overview

Github Repo Reader is a back-end application written in Java that thanks to Github API enables an easy access to the data about user (login,name,bio) and info about his repositories (language,bytes of code).

* * *

### Notable Issues

##### Github API

Due to Github API's rate limitations concerning the amount of times an unathicated user can request data from the server there were some assumptions that had to be made. User that is not authenticated can access data from the API only 60 times per our. That amount of requests wouldn't be enough to read data for a larger number of repositories. In my application every request to the Github API contains an authorization header that contains both a valid github username and verification token stored in a Java class Credentials.java. **This solution is used only for simplicity sakes and would not be allowed in real business/production scenario because it is a serious security threat.** To fully secure this kind of permament credentials they should be kept in a [Vault](https://spring.io/projects/spring-vault) or other auth protocols such as [OAUth2](https://oauth.net/2/) are to be used.

##### Repos with no detectable languages

If a language used in a repo is not listed in [here](https://github.com/github/linguist/tree/master/samples) that means that next to its name a "null" will appear. The same issue may happen for the repositories that are empty.