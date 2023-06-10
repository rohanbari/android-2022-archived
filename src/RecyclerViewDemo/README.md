# RecyclerViewDemo

It is a simple demonstration of the implementation of the RecyclerView Android widget.

## Demonstration

Here is the RecyclerView's adapter:

```java
public class NameAdapter extends RecyclerView.Adapter<NameAdapter.ViewHolder> {
    private final ArrayList<Name> names;

    public NameAdapter(ArrayList<Name> names) {
        this.names = names;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNameBinding binding = ItemNameBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        .
        .
        .
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemNameBinding mBinding;

        public ViewHolder(ItemNameBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public ItemNameBinding getBinding() {
            return mBinding;
        }
    }
}
```

To return the binding dynamically in `onBindViewHolder()`, `public
ItemBindingName getBinding()` is defined, which is the value of `binding` passed
by the line:

    return new ViewHolder(binding);

After setting the adapter, the RecyclerView is successfully able to build a list
of the type defined in `item_name.xml`'s CardView.
