import React, { Component } from 'react'
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { MenuItem, Select } from '@mui/material';

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
};

class UpdateTicketModal extends Component {

    state = {
        priority: '',
        status: '',
        assignTo: '',
        ticketId: ''
    }

    componentDidMount() {

        const { ticketData } = this.props;

        // this.setState({
        // })
    }

    render() {
        return (
            <Modal
                open={this.props.showUpdateTicketModal}
                onClose={this.props.handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <Box sx={style}>
                    <Typography id="modal-modal-title" variant="h6" component="h2">
                        Edit Ticket
                    </Typography>
                    <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                        <Select
                            labelId="demo-simple-select-standard-label"
                            id="demo-simple-select-standard"
                            value={this.props.ticketData.priority}
                            // onChange={(e) => this.setState({ priority: e.target.value })}
                            label="Status"
                        >
                            <MenuItem value={'LOW'}>Low</MenuItem>
                            <MenuItem value={'MODERATE'}>Moderate</MenuItem>
                            <MenuItem value={'HIGH'}>High</MenuItem>
                            <MenuItem value={'VERY_HIGH'}>Very High</MenuItem>
                        </Select>
                    </Typography>
                </Box>
            </Modal>
        )
    }

}

export default UpdateTicketModal;