from django import forms
from .models import Synthesis

class SynthesisForm(forms.ModelForm):
    class Meta:
        model = Synthesis
        fields = ('input_image', 'style_image')