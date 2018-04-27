package com.online.assistencia.assistcell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class Adaptador extends BaseExpandableListAdapter {

    private List<String> lstGrupos;
    private HashMap<String, List<Produto>> lstItensGrupos;
    private Context context;

    public Adaptador(Context context, List<String> grupos, HashMap<String, List<Produto>> itensGrupos) {
        // inicializa as variáveis da classe
        this.context = context;
        lstGrupos = grupos;
        lstItensGrupos = itensGrupos;
    }

    @Override
    public int getGroupCount() {
        // retorna a quantidade de grupos
        return lstGrupos.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // retorna a quantidade de itens de um grupo
        return lstItensGrupos.get(getGroup(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        // retorna um grupo
        return lstGrupos.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // retorna um item do grupo
        return lstItensGrupos.get(getGroup(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        // retorna o id do grupo, porém como nesse exemplo
        // o grupo não possui um id específico, o retorno
        // será o próprio groupPosition
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // retorna o id do item do grupo, porém como nesse exemplo
        // o item do grupo não possui um id específico, o retorno
        // será o próprio childPosition
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        // retorna se os ids são específicos (únicos para cada
        // grupo ou item) ou relativos
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // cria os itens principais (grupos)

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.grupos_categ, null);
        }

        TextView tvGrupo = (TextView) convertView.findViewById(R.id.tvGrupo);
        TextView tvQtde = (TextView) convertView.findViewById(R.id.tvQtde);

        tvGrupo.setText((String) getGroup(groupPosition));
        tvQtde.setText(String.valueOf(getChildrenCount(groupPosition)));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // cria os subitens (itens dos grupos)

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.itens_grupo, null);
        }

        TextView tvItem = (TextView) convertView.findViewById(R.id.tvItem);
        TextView tvValor = (TextView) convertView.findViewById(R.id.tvValor);

        Produto produto = (Produto) getChild(groupPosition, childPosition);
        tvItem.setText(produto.getNome());
        tvValor.setText(String.valueOf(produto.getValor()));

        Button btn_reserva= (Button)convertView.findViewById(R.id.btnReserv);

        btn_reserva.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something

            }
        });
        btn_reserva.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // retorna se o subitem (item do grupo) é selecionável
        return true;
    }
}