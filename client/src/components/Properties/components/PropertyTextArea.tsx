import {Label} from '@/components/ui/label';
import {Textarea, TextareaProps} from '@/components/ui/textarea';
import {Tooltip, TooltipContent, TooltipTrigger} from '@/components/ui/tooltip';
import {ExclamationTriangleIcon, QuestionMarkCircledIcon} from '@radix-ui/react-icons';
import {ReactNode, forwardRef} from 'react';
import {twMerge} from 'tailwind-merge';

interface PropertyTextAreaProps extends TextareaProps {
    description?: string;
    error?: string | undefined;
    label?: string;
    leadingIcon?: ReactNode;
    name: string;
}

const PropertyTextArea = forwardRef<HTMLTextAreaElement, PropertyTextAreaProps>(
    ({description, error, label, leadingIcon, name, required, title, ...props}, ref) => (
        <fieldset className="mb-3 w-full">
            {label && (
                <div className="flex items-center">
                    <Label className={twMerge(description && 'mr-1')} htmlFor={name}>
                        {label}

                        {required && <span className="leading-3 text-red-500">*</span>}
                    </Label>

                    {description && (
                        <Tooltip>
                            <TooltipTrigger>
                                <QuestionMarkCircledIcon />
                            </TooltipTrigger>

                            <TooltipContent>{description}</TooltipContent>
                        </Tooltip>
                    )}
                </div>
            )}

            <div className={twMerge([label && 'mt-1', leadingIcon && 'relative'])} title={title}>
                <div className={twMerge(leadingIcon && 'relative rounded-md')}>
                    {leadingIcon && (
                        <div className="pointer-events-none absolute inset-y-0 left-0 flex items-center rounded-l-md border border-gray-300 bg-gray-100 px-3">
                            {leadingIcon}
                        </div>
                    )}

                    <Textarea id={name} name={name} ref={ref} rows={5} {...props} />

                    {error && (
                        <div className="pointer-events-none absolute inset-y-0 right-0 flex items-center pr-3">
                            <ExclamationTriangleIcon aria-hidden="true" className="size-5 text-red-500" />
                        </div>
                    )}
                </div>
            </div>

            {error && (
                <p className="mt-2 text-sm text-red-600" id={`${name}-error`} role="alert">
                    This field is required
                </p>
            )}
        </fieldset>
    )
);

PropertyTextArea.displayName = 'PropertyTextArea';

export default PropertyTextArea;
