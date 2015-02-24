function handleSubmit(args, dialog, dialog2) {
    var jqDialog = jQuery('#' + dialog);
    if (args.validationFailed) {
        jqDialog.effect('shake', {times: 3}, 100);
    } else {
        PF(dialog).hide();
        PF(dialog2).hide();
        PF(dialog2).show();
    }
}