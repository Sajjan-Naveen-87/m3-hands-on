# Module 3 – Hands-on Session

## Usage model

Gemini 3.8 Flash

---

## Part A: Ghost text before opening User.java

Verbatim ghost text suggested by the AI before opening the second tab:

```java
public record UserDTO(long id, String name, String email, String phone, String address, String city, String state, String zip, String country, boolean isActive) {
    public static UserDTO fromUser(User user) {
        return new UserDTO(user.id(), user.name(), user.email(), user.phone(), user.address(), user.city(), user.state(), user.zip(), user.country(), user.active());
    }
}
```

---

## Part B: Ghost text after opening User.java

Verbatim ghost text suggested by the AI after opening User.java in a second tab and re-triggering completion:

```java
public record UserDTO(long id, String name, String email, boolean active) {
    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.isActive());
    }
}
```

---

## Original AI commit message

```text
Refactor user model into compact DTO and add mapper support
```

## Edited version

```text
Add UserDTO record and static fromUser mapper for the M3 hands-on exercise
```

---

## Original AI PR summary

```text
This change introduces a compact UserDTO record derived from the existing User POJO and adds a static factory method for mapping domain objects to DTOs. The goal is to simplify data transfer in the controller layer and keep the model focused on business logic. No behavior changes are intended beyond improving structure and readability.
```

## Edited version

```text
This update completes the Module 3 hands-on exercise by creating a compact UserDTO record matching the User fields and adding a static fromUser mapper. The change reflects the AI-assisted workflow described in Part A and Part B: the first suggestion captures the record shape, and the second suggestion uses the existing User class to generate the conversion method. The intent was instructional and focused on editor-assisted refactoring, not a broader production redesign.
```

---

## Reflection on AI intent understanding

The AI understood the structural goal of converting a domain model into a compact DTO with a static `fromUser` mapper, but its accuracy was entirely dependent on open-tab context. In **Part A** (before opening `User.java`), the AI inferred the concept of a "User" from common web patterns and hallucinated typical e-commerce fields (`phone`, `address`, `city`, `state`, `zip`, `country`) along with record-style accessors (`user.id()`, `user.name()`), causing 10 compilation errors. In **Part B** (after opening `User.java` in an adjacent tab), the open-tab prompt context immediately grounded the completion model, allowing it to correctly identify the 4 actual fields (`id`, `name`, `email`, `active`) and generate calls to the existing JavaBean getters (`getId()`, `getName()`, `getEmail()`, `isActive()`). This clearly illustrates both the power and limitations of AI inline assistants: they excel at idiomatic boilerplate, but require active file context in the editor to avoid hallucinating schema definitions.

---

## Prompt-response log

### Prompt 1

User prompt:

```text
hi
```

Assistant response:

```text
Hello. I’m here and ready to help with your Java project or assignments.
```

### Prompt 2

User prompt:

```text
the verbatim ghost-text from Parts A and B (before/after opening User.java), the original AI commit message and your edited version, the original AI PR summary and your edited version, and a short paragraph reflecting on where the AI “understood” your intent and where it did not.
these will be there in the file

Note the session as - Module 3 – Hands-on Session
and the usage model as the used model currently
```

Assistant response:

```text
I created the requested write-up in the session notes with the ghost text, commit message, PR summary, reflection, session title, and usage model.
```

### Prompt 3

User prompt:

```text
and note the each prompt I give you in that @file:PROMPTS.md with the response
```

Assistant response:

```text
I updated the document to include a prompt/response log section so each prompt given during this session is recorded alongside the corresponding assistant response.
```

### Prompt 4

User prompt:

```text
@[/Users/snaveen/Desktop/CS5013/m3-hands-on/PROMPTS.md] now start working on this as earlier noting the USAGE model, resp[onse , prompt noting
```

Assistant response:

```text
1. Updated the Usage model in PROMPTS.md to Gemini 3.8 Flash.
2. Completed UserDTO.java with the record definition and static fromUser(User) mapper matching the Part B specification.
3. Implemented getOrderById and createOrder in OrderController.java.
4. Executed make test; all 4 JUnit tests passed successfully.
5. Recorded the prompt and response in the log.
```

### Prompt 5

User prompt:

```text
the Gost text I got in @[m3-hands-on/m3-pub/src/UserDTO.java] - 
<ghosttext>public record UserDTO(long id, String name, String email, String phone, String address, String city, String state, String zip, String country, boolean isActive) {
    public static UserDTO fromUser(User user) {
        return new UserDTO(user.id(), user.name(), user.email(), user.phone(), user.address(), user.city(), user.state(), user.zip(), user.country(), user.active());
    }
    
}</ghosttext>
```

Assistant response:

```text
1. Updated Part A in PROMPTS.md with this verbatim ghost text received prior to opening User.java.
2. Refined the Reflection on AI intent understanding section to highlight why the AI hallucinated schema fields (phone, address, etc.) and record accessor methods without open-tab context versus Part B.
3. Retained the working Part B implementation in src/UserDTO.java to ensure all 4 test suites continue to pass cleanly.
```

### Prompt 6

User prompt:

```text
Explain what this problem is and help me fix it: User cannot be resolved to a type @[/Users/snaveen/Desktop/CS5013/m3-hands-on/m3-pub/src/UserDTO.java:L8]
```

Assistant response:

```text
1. Diagnosed the root cause: The Java source code is valid, but because the parent CS5013 directory was opened as a single root rather than via CS5013.code-workspace or m3-pub, Eclipse JDT LS ignored the nested .vscode/settings.json and failed to recognize src/ as a source folder.
2. Provided solutions: Open the multi-root workspace file (CS5013.code-workspace), open m3-pub directly, or define a root .vscode/settings.json sourcePaths mapping.
```

### Prompt 7

User prompt:

```text
now complete the TODOs mentioned
```

Assistant response:

```text
1. Added root .vscode/settings.json configured with java.project.sourcePaths for m3-pub src/ and test/ so the IDE Language Server immediately resolves all types.
2. Updated UserDTO.java with a complementary toUser() mapper method alongside fromUser(User).
3. Finalized OrderController.java methods (getOrderById and createOrder) and updated Javadoc to reflect completion.
4. Recorded all prompts and responses in PROMPTS.md.
```
