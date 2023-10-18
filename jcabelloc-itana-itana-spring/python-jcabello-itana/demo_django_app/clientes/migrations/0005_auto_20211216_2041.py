# Generated by Django 3.2.8 on 2021-12-16 20:41

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('clientes', '0004_orden'),
    ]

    operations = [
        migrations.CreateModel(
            name='Producto',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('cod_producto', models.CharField(max_length=6)),
                ('nombre', models.CharField(max_length=100)),
                ('precio_pen', models.DecimalField(decimal_places=2, max_digits=7)),
            ],
        ),
        migrations.AlterModelOptions(
            name='orden',
            options={'verbose_name_plural': 'ordenes'},
        ),
        migrations.AlterField(
            model_name='orden',
            name='cliente',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.SET_NULL, related_name='ordenes', to='clientes.cliente'),
        ),
        migrations.AddField(
            model_name='orden',
            name='productos',
            field=models.ManyToManyField(to='clientes.Producto'),
        ),
    ]