# RuntimeObjectCreation

I have defined a counter variable to set a unique text for each new button:

    private int counter = 0;

Note that I have used the viewBinding feature. To use it, open the Gradle script
of your module, and then write within `android {}`:

```gradle
buildFeatures {
    viewBinding true
}
```

Let's move on. This line:

    binding.buttonMain.setOnClickListener(v -> createNewButton());

It is intended to handle the `OnClickListener` event via an anonymous function calling
the `createNewButton()` method. The `createNewButton()` is defined as follows:

```java
void createNewButton() {
    Button button = new Button(this);

    String output = "New Button " + counter++;
    button.setText(output);

    button.setOnClickListener(v -> createNewButton());

    binding.getRoot().addView(button);
}
```

To create new button instances, we have instantiated a `button` object and assigned
the text with incremented `counter` value on each click at any button. Then, recursively
handled the `OnClickListener` event. Finally, the button is added to the activity.
