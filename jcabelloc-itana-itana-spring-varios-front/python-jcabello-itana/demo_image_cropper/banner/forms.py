from django import forms
from .models import Banner


class BannerForm(forms.ModelForm):
    class Meta:
        model = Banner
        # The fields that will be visible in the form
        fields = ['name', 'image']
