package com.example.mybooklibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.Visibility;
import android.text.Layout;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder>{
    private ArrayList<Book> books = new ArrayList<>();
    final private String parentActivity;
    final private Context mcontext;

    public BookRecViewAdapter(String parentActivity, Context mcontext) {
        this.parentActivity = parentActivity;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text.setText(books.get(position).getName());

        Glide.with(mcontext)
                .asBitmap().load(books.get(position).getImageUrl())
                .into(holder.image);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, BookActivity.class);
                intent.putExtra("BookId", books.get(position).getId());

                mcontext.startActivity(intent);
            }
        });
        holder.author.setText(books.get(position).getAuthor());
        holder.shortDesc.setText(books.get(position).getShortDesk());

        if (books.get(position).isExpanded()) {
            TransitionManager.beginDelayedTransition(holder.card);
            holder.expanded.setVisibility(View.VISIBLE);
            holder.down.setVisibility(View.GONE);
            if (parentActivity.equals("AllBooks")) {
                holder.btnDelete.setVisibility(View.GONE);
            } else if (parentActivity.equals("FavBooks")) {
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName() + " ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (Utils.removeFavouriteBooks(books.get(position))) {
                                    Toast.makeText(mcontext, "Book removed.", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                } else {
                                    Toast.makeText(mcontext, "Something went wrong.", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.create().show();

                    }
                });

            } else if (parentActivity.equals("CurrentBooks")) {
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName() + " ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (Utils.removeCurrentlyReadingBooks(books.get(position))) {
                                    Toast.makeText(mcontext, "Book removed.", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                } else {
                                    Toast.makeText(mcontext, "Something went wrong.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.create().show();


                    }
                });

            } else if (parentActivity.equals("Wishlist")) {
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName() + " ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (Utils.removeWishlist(books.get(position))) {
                                    Toast.makeText(mcontext, "Book removed.", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                } else {
                                    Toast.makeText(mcontext, "Something went wrong.", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.create().show();

                    }
                });
            } else if (parentActivity.equals("already")) {
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName() + " ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (Utils.removeAlreadyReadBooks(books.get(position))) {
                                    Toast.makeText(mcontext, "Book removed.", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                } else {
                                    Toast.makeText(mcontext, "Something went wrong.", Toast.LENGTH_SHORT).show();
                                }
                                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                builder.create().show();

                            }
                        });
                    }


                });
            } else {
                TransitionManager.beginDelayedTransition(holder.card);
                holder.expanded.setVisibility(View.GONE);
                holder.down.setVisibility(View.VISIBLE);

            }

        }
    }

    @Override
    public int getItemCount() {
        return this.books.size();
    }

    public void setBooks(ArrayList<Book> books){
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView card;
        private ImageView image;
        private TextView text, btnDelete;

        private ImageView up, down;
        private RelativeLayout expanded;
        private TextView author, shortDesc;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.parent);
            image = itemView.findViewById(R.id.imgBook);
            text = itemView.findViewById(R.id.txtBookName);
            expanded = itemView.findViewById(R.id.expandedLayout);
            up = itemView.findViewById(R.id.up);
            down = itemView.findViewById(R.id.down);
            author = itemView.findViewById(R.id.txtAuthor);
            shortDesc = itemView.findViewById(R.id.shortdsc);
            btnDelete = itemView.findViewById(R.id.btnDelete);

            down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
            up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });




        }
    }
}
